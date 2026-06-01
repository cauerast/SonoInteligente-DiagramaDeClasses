package dc.unifacef.sonoInteligenteSpring.Model;

import dc.unifacef.sonoInteligenteSpring.Model.Autenticacao;
import dc.unifacef.sonoInteligenteSpring.Model.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Administrador implements Autenticacao {
    private Long id;
    private String nome, email, senha;
    private ArrayList<Paciente> pacientes;
    private boolean isLogged;

    public Administrador() {
        this.pacientes = new ArrayList<>();
        this.isLogged = false;
    }

    public Administrador(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pacientes = new ArrayList<>();
        this.isLogged = false;
    }

    public void setId(Long id) {
        this.id = this.id;
    }

    public void setNome(String nome) {
        this.nome = this.nome;
    }

    public void setEmail(String email) {
        this.email = this.email;
    }

    public void setSenha(String senha) {
        this.senha = this.senha;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public ArrayList getPacientes() {
        return this.pacientes;
    }

    @Override
    public String toString() {
        return "\n\tAdministrador {" +
                "\nId: " + this.id +
                "\nNome: " + this.nome +
                "\nEmail: " + this.email +
                "\nSenha: " + this.senha +
                "\nPacientes: " + this.pacientes +
                '}';
    }

    @Override
    public void login(String email, String senha){
        if(email.equals("administrador@gmail.com") && senha.equals("SI1235")){
            this.isLogged = true;
            System.out.println("Logado como administrador na Sono Longeligente...");
        } else {
            System.out.println("Email ou senha incorretos!");
        }
    }

    @Override
    public void logout(){
        this.isLogged = false;
        System.out.println("Saindo da conta...");
    }

    public void cadastrarPaciente(Long id, String nome, String CPF, String cidade, String telefone, LocalDate dataNasc){
        this.pacientes.add(new Paciente(id, nome, CPF, cidade, telefone, dataNasc));
    }

    public Paciente getPaciente(Long id){
        for(Paciente p : this.pacientes){
            if(Objects.equals(p.getId(), id)){
                return p;
            }
        }
        return null;
    }
}
