# APIGerenciarPessoas
## Do que se trata:
- API com CRUD de Pessoas e Endereço com um adendo de listar Pessoa com seus respectivos endereços.
##Como utlizar:
- Utilizar algum software de API Client, para testar esse projeto utilizei Postman, então fica como recomendação.
- Estartar a aplicação em alguma ide que aceite Java.
###Criar Pessoa:
- Escolher como tipo de requisição o POST
- Incluir URI: http://localhost:8080/pessoas
- Selecionar Body 
- Selecionar raw e escolher tipo JSON
- Colocar como body o seguinte Json:
{ "nome":"nomeDaPessoaAqui","dataNascimento":"dataNascimentoDaPessoaAqui" }, exemplo visual abaixo:
![Post Pessoa](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/postPessoa.png)
- Clicar em Send
- Saída:
  ![Post Pessoa](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/ResponsePostPessoa.png)
- Como pode notar o status é 201 ou seja foi criado e a aplicação gerou um id para o Json inserido.
###Criar Endereço:
- Escolher como tipo de requisição o POST
- Incluir URI: http://localhost:8080/enderecos
- Selecionar Body
- Selecionar raw e escolher tipo JSON
- Colocar como body o seguinte Json:
- {  
  "pessoaId": O id que foi gerado ao criar a Pessoa,
  "logradouro": "LogradouroDaPessoaAqui",
  "cep": "CepDoEndereçoDaPessoaAqui",
  "numero": "NumeroEndereçoAqui",
  "cidade": "cidadeAqui",
  "enderecoEnum": "Escolher se o endereço é SECUNDARIO ou PRINCIPAL"
  }
- Clicar em Send, exemplo abaixo:
  ![Post Endereco](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/postEndereco.png)
- Saída:
  ![Post Endereco](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/responsePostEndereco.png)
- Como pode notar o status é 201 ou seja foi criado e a aplicação gerou um id para o Json inserido.
###Listar Pessoa com o respectivo endereço:
- Escolher como tipo de requisição como GET
- Incluir URI: http://localhost:8080/pessoas/lista/1
- Clicar em Send
  ![GET Lista Pessoa Endereco](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/ListaPessoaEndereco.png)
- Saída:
  ![GET Lista Pessoa Endereco](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/ResponseListaPessoaEndereco.png)
###Listar Pessoas
- Escolher como tipo de requisição como GET
- Incluir URI: http://localhost:8080/pessoas
- Clicar em Send
  ![GET Lista Pessoa ](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/getPessoas.png)
- Saída:
  ![GET Lista Pessoa Endereco](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/responseGetPessoas.png)
###Listar Endereços
- Escolher como tipo de requisição como GET
- Incluir URI: http://localhost:8080/enderecos
- Clicar em Send
  ![GET Lista  Enderecos](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/getEnderecos.png)
- Saída:
  ![GET Lista  Enderecos](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/responseEndereco.png)
###Update Pessoa
- Escolher como tipo de requisição o PUT
- Incluir URI: http://localhost:8080/pessoas/id
- Selecionar Body
- Selecionar raw e escolher tipo JSON
- Colocar como body o Json com as chaves  necessárias e a alteração no valor
- Exemplo visual abaixo:
  ![PUT Endereco](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/updatePessoa.png)
- No caso alterei a data de nascimento
- Saída:
  ![PUT Endereco response](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/updateResponse.png)
###Lista Pessoa de um id especifico
- Escolher como tipo de requisição o GET
- Incluir URI: http://localhost:8080/pessoas/id
- Clicar em send, estou pesquisando id=2, exemplo abaixo:
 ![GET Pessoa](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/getPessoaId.png)
- Saída:
 ![GeT Pessoa Response](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/responseGETIdPessoa.png)
  ###Deletar Pessoa
- Escolher como tipo de requisição o DELETE
- Incluir URI: http://localhost:8080/pessoas/id
- Clicar em Send, e como pode ver no exemplo abaixo status de sucesso na requisição para deletar id=2:
![Delete Pessoa](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/DeletePessoa.png)
###Update Endereço
- Escolher como tipo de requisição o PUT
- Incluir URI: http://localhost:8080/enderecos/id
- Selecionar Body
- Selecionar raw e escolher tipo JSON
- Colocar como body o  Json com as chaves necessárias com as devidas alterações no valor :
- No exemplo abaixo alterei o logradouron:
  ![Update Endereco](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/putEndereco.png)
- Saída:
  ![Update Endereco](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/updateEnderecoResponse.png)
###Listar endereço de um id especifico
- Escolher como tipo de requisição o GET
- Incluir URI: http://localhost:8080/enderecos/id
- Clicar em send, no exemplo abaixo pesquisei endereço com id=1
  ![Get id  Endereco](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/getIDEndereco.png)
- Saída:
 ![Get id  Endereco](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/responseGetIdEndereco.png)
###Delete Endereço
- Escolher como tipo de requisição o DELETE
- Incluir URI: http://localhost:8080/enderecos/id
- Clicar em send, no exemplo abaixo deletei endereço com id=1 e pode notar o status de sucesso na requisição:
  ![Get id  Endereco](H:\Users\WINDOWS\Desktop\Java\teste2\GerenciarPessoas\GerenciarPessoas\imgReadme/delete Endereco.png)