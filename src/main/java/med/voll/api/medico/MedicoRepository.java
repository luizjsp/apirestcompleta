package med.voll.api.medico;

//criação do repositorio jpa - para persistir os dados do médico no banco.
//passamos para o JpaRepository a entidade e a propriedade primária
//criado uma classe de metodo do listar medicos ativos do banco

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
