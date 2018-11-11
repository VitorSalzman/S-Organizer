/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    public Prestador(String cpf, String usuario, String senha, String nome, String telefone, HorarioTrabalho horarioTrabalho, Empresa empresa, Agenda agenda) {
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.horarioTrabalho = horarioTrabalho;
        this.empresa = empresa;
        this.agenda = agenda;
    }

    public Prestador() {
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Long id;
    
    @Column(length=20, name = "CPF")
    private String cpf;
    @Column(length=255, name = "usuario")
    private String usuario;
    @Column(length=255, name = "senha")
    private String senha;
    @Column(length=100, name = "nome")
    private String nome;
    @Column(length=20, name = "telefone") // não precisa de length ja q é bigint
    private String telefone;
    
    @OneToOne
    private HorarioTrabalho horarioTrabalho;
    @OneToOne
    private Empresa empresa;
    @OneToOne
    private Agenda agenda; // can be null
    private List servicos = new ArrayList(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public HorarioTrabalho getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(HorarioTrabalho horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public List getServicos() {
        return servicos;
    }

    public void setServicos(List servicos) {
        this.servicos = servicos;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.cpf);
        hash = 13 * hash + Objects.hashCode(this.usuario);
        hash = 13 * hash + Objects.hashCode(this.senha);
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.telefone);
        hash = 13 * hash + Objects.hashCode(this.horarioTrabalho);
        hash = 13 * hash + Objects.hashCode(this.empresa);
        hash = 13 * hash + Objects.hashCode(this.agenda);
        hash = 13 * hash + Objects.hashCode(this.servicos);
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
        if (!Objects.equals(this.cpf, other.cpf)) {
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
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.horarioTrabalho, other.horarioTrabalho)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.agenda, other.agenda)) {
            return false;
        }
        if (!Objects.equals(this.servicos, other.servicos)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Prestador{" + "id=" + id + ", cpf=" + cpf + ", usuario=" + usuario + ", senha=" + senha + ", nome=" + nome + ", telefone=" + telefone + ", horarioTrabalho=" + horarioTrabalho + ", empresa=" + empresa + ", agenda=" + agenda + ", servicos=" + servicos + '}';
    }

      
}