# JmsIntroMdb
An Introduction to JMS using MDBs

Download and Install Apache TomEE PLUS: https://tomee.apache.org/download-ng.html
  -Extract to preferred directory, and setup CATALINA_HOME environment variable to point to installation location
  
Open ${CATALINA_HOME}\conf\tomee.xml and add the following:

    <Resource id="MyJmsResourceAdapter" type="ActiveMQResourceAdapter">
        # Do not start the embedded ActiveMQ broker
        BrokerXmlConfig  =
        ServerUrl = tcp://localhost:61616
    </Resource>

    <Resource id="MyJmsConnectionFactory" type="javax.jms.ConnectionFactory">
        ResourceAdapter = MyJmsResourceAdapter
    </Resource>

    <Container id="MyJmsMdbContainer" ctype="MESSAGE">
        ResourceAdapter = MyJmsResourceAdapter
    </Container>

    <Resource id="Q.za.co.entelect.dojo.jms" type="javax.jms.Queue"/>
    
 This sets up your TomEE server to connect to the ActiveMQ instance we setup in the earlier practical (paste URL here)
 
 Build this project, paste the generated jar in ${CATALINA_HOME}\webapps.
 
 Start your tomEE server ${CATALINA_HOME}\bin\startup.bat
 
 Your MDB should initialize and await messages. Publish a message on activeMQ. See your MDB in action.
