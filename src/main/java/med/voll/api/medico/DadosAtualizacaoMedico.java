package med.voll.api.medico;

//DTO só para o metodo de atualização do cadastro do médico (id, nome, telefone, endereço (outro DTO))
//validar o id como obrigatorio = não nulo.

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
