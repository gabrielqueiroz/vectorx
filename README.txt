Java JSF com login e gerenciamento de Feriados e Pontos Facultativos de 2015.

*Criar Banco de Dados 'operador' no PostgreeSQL caso nao exista.
*Tabela sera criada automaticamente caso nao exista, e o insert de datas sera feito automaticamente caso nao possua datas no banco de dados.
*Maven build: INSTALL CLEAN JBOSS:REDEPLOY
*WebService SOAP DiasSOAP utilizado para verificar feriados, pontos facultativos, sabados ou domingos.
(Utilize http://localhost:8263/vectorxClient/sampleDiasSOAPProxy/TestClient.jsp?endpoint=http://localhost:8263/vectorx/services/DiasSOAP) para testar o WebService por enquanto.