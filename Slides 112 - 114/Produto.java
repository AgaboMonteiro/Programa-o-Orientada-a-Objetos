/*1 - Crie uma classe Produto com nome e preço e na main crie 2 objetos e exiba os
dados. 

1
Modifique a classe Produto (Exercício 1) para ter dois construtores (um com 2
parâmetros e um com apenas 1).*/

public class Produto{
        private String nome;
        private double preco;

        public void nome(String nome) {
            this.nome = nome;
        }

        public void preco(double preco) {
            this.preco = preco;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        public Produto(){//construtor 0
        }

        public Produto(String nome){//construtor 1 
            this.nome = nome;
        }

        public Produto(String nome, double preco) { //construtor 2
            this.nome = nome;
            this.preco = preco;
        }


       
    }

  
