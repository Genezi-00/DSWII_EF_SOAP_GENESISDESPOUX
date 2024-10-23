package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class DocenteWsdlConfig {

    @Bean(name = "docentes")
    public DefaultWsdl11Definition docenteWsdl11Definition(XsdSchema docenteEsquema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("DocentesPort");
        wsdl11Definition.setLocationUri("/ws/docente");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/object");
        wsdl11Definition.setSchema(docenteEsquema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema docenteEsquema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/docente.xsd"));
    }
}