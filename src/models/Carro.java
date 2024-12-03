package models; // Pacote para ser utilizada em outros arquivos no projeto

// Classe principal
public class Carro {
    // Criação das variáveis
    private int id;
    private String marca;
    private String modelo;
    private String cor;
    private String ano;
    private String motor;
    private String cambio;

    // Construtores
    public Carro() {
    }

    public Carro(String marca, String modelo, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public Carro(int id, String marca, String modelo, String cor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public Carro(int id, String marca, String modelo, String cor, String ano) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    public Carro(int id, String marca, String modelo, String cor, String ano, String motor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.motor = motor;
    }

    public Carro(int id, String marca, String modelo, String cor, String ano, String motor, String cambio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.motor = motor;
        this.cambio = cambio;
    }

    public Carro(String marca, String modelo, String cor, String ano, String motor, String cambio) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.motor = motor;
        this.cambio = cambio;
    }

    // Getters e Setters

    public int getID() {
        return id;
    }

    // ID somente leitura, sem setter

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    // toString
    @Override
    public String toString() {
    return "Contato [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", ano=" + ano + ", motor=" + motor + ", câmbio=" + cambio + "]";
    }
}