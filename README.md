# soreclamacoes
Reclamações de clientes sobre prestação de serviços.

Para testar, basta baixar esse repositório:

git clone https://github.com/josepojr/soreclamacoes

Depois, executar o comando maven:

mvn clean install

Por último, execute o servidor + aplicação (contido num único jar):

java -jar target/soreclamacoes-1.0.0-FINAL.jar

Com a aplicação no ar, acesse o seguinte endereço para testá-la:

http://127.0.0.1:8080/

Será redirecionada (pois HTTPS está ativado) para:

http://127.0.0.1:8443/

E pedirá uma senha do autorizador padrão.

Essa senha aparecerá no log a cada reinicio do servidor tomcat embutido.

O usuário é "user".
