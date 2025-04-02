package br.com.barbershop.service;

import br.com.barbershop.dto.DadosAgendamento;
import br.com.barbershop.model.Barber;
import br.com.barbershop.model.Scheduling;
import br.com.barbershop.repository.BarberRepository;
import br.com.barbershop.repository.ClientRepository;
import br.com.barbershop.repository.SchedulingRepository;
import br.com.barbershop.repository.ServiceRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    @Autowired
    private SchedulingRepository Schedulingrepository;

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public void agendar(DadosAgendamento dados){
        //Verificando se existe no banco de daodos os ids passados, e em barbeiro, que ano é obrigatorio estou vendo se não veio null
        if (dados.idBarber() != null && !barberRepository.existsById(dados.idBarber())){
            throw new ValidationException("Barbeiro nao encontrado");
        }
        if (!clientRepository.existsById(dados.idClient())){
            throw new ValidationException("Cliente nao encontrado");
        }
        if (!serviceRepository.existsById(dados.idService())){
            throw new ValidationException("Serviço nao encontrado");
        }

        //Buscado as entidas pelo id delas no banco
        var barber = escolherBarber(dados);
        var client = clientRepository.getReferenceById(dados.idClient());
        var service = serviceRepository.getReferenceById(dados.idService());
        //Passando os argumentos para o metodo construtor da classe scheduling
        var scheduling = new Scheduling (null, client, barber, service, dados.data(), dados.observacao(), dados.status());

        //salvando no banco as informações recebidas
        Schedulingrepository.save(scheduling);
    }

    private Barber escolherBarber(DadosAgendamento dados) {
        if (dados.idBarber() != null){
            return barberRepository.getReferenceById(dados.idBarber());
        }

        return barberRepository.escolherBarbeiroDisponivelAleatorio(dados.data());
    }
}
