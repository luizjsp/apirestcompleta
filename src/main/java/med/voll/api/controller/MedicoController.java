package med.voll.api.controller;

//mapeamento da url medicos. - RestController e RequestMapping
//metodo post(cadastrar medicos) json - PostMapping
//receber a requisição body (corpo) json - RequestBody
//foi criado uma classe record DadosCasdastroMedico para receber parametros de forma separada.

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    //injeção de dependencia
    //colocando a anotação bean validatin - Valid para o DTO
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));




    }
    //metodo get (listar) com paginação (Pageable)
    //paginação por ordenação padrão (customizada): pelo nome e 10 dados por pagina.
    //alterado para listar só os id ativos = 1
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);

    }

    //metodo para atualizar dados do medico
    //fazer um novo DTO só para
    //criar uma var e pegar no repositorio (banco) a referencia id.
    //criar outro método e classe para atualizar informações
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);


    }
    //metodo de excluir (fisica) por id do medico
    //metodo de excluir de forma lógica (inativando) no banco
    //colocando anotação @pathvariable para definir onde está o caminho do id
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        //repository.deleteById(id);
        var medico = repository.getReferenceById(id);
        medico.excluir();

    }


}
