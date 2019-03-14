package springboot.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//@EnableWs
//@Configuration
//public class Config extends WsConfigurerAdapter
//{
//    @Bean
//    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)
//    {
//        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//        servlet.setApplicationContext(applicationContext);
//        servlet.setTransformWsdlLocations(true);
//        return new ServletRegistrationBean(servlet, "/ws/*");
//    }
//
//    @Bean(name = "date")
//    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema dateSchema)
//    {
//        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//        wsdl11Definition.setPortTypeName("CurrentDatePort");
//        wsdl11Definition.setLocationUri("/ws");
//        wsdl11Definition.setTargetNamespace("http://localhost:8080/xml/date");
//        wsdl11Definition.setSchema(dateSchema);
//        return wsdl11Definition;
//    }
//
//    @Bean
//    public XsdSchema dateSchema()
//    {
//        return new SimpleXsdSchema(new ClassPathResource("date.xsd"));
//    }
//}
