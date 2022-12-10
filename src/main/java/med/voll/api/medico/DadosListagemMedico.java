package med.voll.api.medico;

//DTO para listar só as informações solicitadas: nome, email, crm e especialidade.

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
    //criado construtor para chamar as propriedades
    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());

    }
}
