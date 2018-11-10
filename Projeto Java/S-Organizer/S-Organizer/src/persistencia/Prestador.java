/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author luizg
 */
@Entity
public class Prestador implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Long id;
    
    @Column(length=100, name = "empresaQueTrabalha")
    private String empresaQueTrabalha;
    @Column(length=1, name ="disponibilidade")
    private boolean disponibilidade;
    @Column(length=11, name = "CPF")
    private long cpf;
    @Column(length=255, name = "usuario")
    private String usuario;
    @Column(length=255, name = "senha")
    private String senha;
    @Column(length=100, name = "nome")
    private String nome;
    @Column(length=12, name = "telefone") // não precisa de length ja q é bigint
    private long telefone;
    
    @OneToOne
    private HorarioTrabalho horarioTrabalho;

    /*
    Define as variaveis
    cria toString
    criar hash e equals
    criar get e set
    Atualizar Controlador
    Limpar banco de dados
    testa se ta persistindo
    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresaQueTrabalha() {
        return empresaQueTrabalha;
    }

    public void setEmpresaQueTrabalha(String empresaQueTrabalha) {
        this.empresaQueTrabalha = empresaQueTrabalha;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public HorarioTrabalho getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(HorarioTrabalho horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.empresaQueTrabalha);
        hash = 59 * hash + (this.disponibilidade ? 1 : 0);
        hash = 59 * hash + (int) (this.cpf ^ (this.cpf >>> 32));
        hash = 59 * hash + Objects.hashCode(this.usuario);
        hash = 59 * hash + Objects.hashCode(this.senha);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + (int) (this.telefone ^ (this.telefone >>> 32));
        hash = 59 * hash + Objects.hashCode(this.horarioTrabalho);
        return hash;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prestador other = (Prestador) obj;
        if (this.disponibilidade != other.disponibilidade) {
            return false;
        }
        if (this.cpf != other.cpf) {
            return false;
        }
        if (this.telefone != other.telefone) {
            return false;
        }
        if (!Objects.equals(this.empresaQueTrabalha, other.empresaQueTrabalha)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.horarioTrabalho, other.horarioTrabalho)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prestador{" + "id=" + id + ", empresaQueTrabalha=" + empresaQueTrabalha + ", disponibilidade=" + disponibilidade + ", cpf=" + cpf + ", usuario=" + usuario + ", senha=" + senha + ", nome=" + nome + ", telefone=" + telefone + ", horarioTrabalho=" + horarioTrabalho + '}';
    }

    
    
}
    