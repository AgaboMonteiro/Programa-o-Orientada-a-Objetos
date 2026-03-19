  /*2 - Crie uma classe Aluno com nome e nota e na main crie 3 alunos e exiba todos. */
  public class Aluno {
        private String nome;
        private float nota;

        public void nome(String nome) {
            this.nome = nome;
        }

        public void nota(float nota) {
            this.nota = nota;
        }
        
        public String getNome() {
            return nome;
        }

        public float getNota() {
            return nota;
        }

        public Aluno(String nome, float nota) {
            this.nome = nome;
            this.nota = nota;
        }

    }
