# Desafio-prático-ZETTA
Foi implementado como desafio para estágio um sistema de gerenciamento de usuários em uma empresa.

## Tecnologias utilizadas 
 - Java 
 - jFrame
 - PostGreSQL
 
 ## Como utilizar
 
 1- Configure o ambiente de desenvolvimento instalando:
 
  - NetBeans
  - JavaSDK
  - PostGreSQL (**Lembre sua senha cadastrada**)
  
  2- Inicie o PostGreSQL e siga os passos:
  
   - 2.1- Crie um novo banco de dados com o nome "empresa";<br />
   - 2.2- Logo após execute um propt de comando na pasta bin do postGreSQL (Caminho padrão:C:\Program Files\PostgreSQL\10\bin);<br />
   - 2.3- Execute o seguinte comando:
     ```bash
     psql -U SEU USUARIO DO POSTREGES -d empresa -1 -f CAMINHO PARA O ARQUIVO .SQL CHAMADO EMPRESA
     ```
   
   - 2.4 Após isso basta ir no arquivo conexao.java (dentro da pasta dao) e colocar seu usuário e senha cadastrado no postGreSQL;<br />
   - 2.5 Execute pelo netBeans.
   
      Obs: Duvida sobre instalação do banco de dados segue video para ajudar: [Link](https://www.youtube.com/watch?v=ng60lcr1jBU)
  
  
  3- Manual de Utilização do Software: [Link](https://drive.google.com/file/d/1JimqF3pm8FiB3hEipoRQNDZQMNOIbTIu/view?usp=sharing)


