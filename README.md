# bolsaValores
Simulação dos processos da bolsa de valores

Este projeto é desenvolvido em Maven, Spring Boot e JSP.

Para executar o projeto é necessário alterar algumas configurações no arquivo application.properties
* spring.datasource.url=jdbc:postgresql://IP:PORTA/bolsa
* spring.datasource.username=USUÁRIO DO BANCO
* spring.datasource.password=SENHA DO BANCO

* spring.mail.host=SMTP DO E-MAIL
* spring.mail.port=PORTA SMTP
* spring.mail.username=USUÁRIO DE E-MAIL
* spring.mail.password=SENHA

Estas configurações de e-mail são utilizadas para enviar as informações sobre as transações realizadas pelo sistema.

O projeto possui o cadastro de empresas, que possuem um valor de ação para as transações, o cadastro de contas, onde é informado 
um e-mail e o saldo disponível para realizar as transações, e o cadastro de monitoramentos, onde é informado o valor de compra e 
venda das ações para que o sistema possa realizar esse processo de forma automática.
Na página inicial há a opção "Inciar Processo". Quando este recurso for acessado uma thread será iniciada no servidor para que 
realize o monitoramento e as transações automáticas.
