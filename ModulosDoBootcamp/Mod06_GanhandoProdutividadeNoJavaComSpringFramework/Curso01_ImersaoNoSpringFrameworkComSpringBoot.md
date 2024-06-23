# Imersão no Spring Framework com Spring Boot
## SPRING FRAMEWORK - Introdução

### O que é Spring Framework
É um framework open source desenvolvido para a plataforma Java baseado nos padrões de projetos inversão de controle e injeção de dependências.

O Spring Framework é uma plataforma abrangente para o desenvolvimento de aplicações Java. Ele fornece suporte de infraestrutura para desenvolver aplicações robustas, eficientes e seguras. Lançado pela primeira vez em 2003, o Spring é projetado para simplificar a criação de aplicações empresariais, oferecendo uma série de recursos e ferramentas que ajudam a resolver problemas comuns de desenvolvimento. Entre seus componentes principais estão o Spring Core, Spring MVC, Spring Data, Spring Security, Spring Batch e Spring Boot, entre outros.

### Spring Versus Java EE

Java EE (Enterprise Edition) é uma plataforma padrão para aplicações empresariais em Java, definida pela Oracle e pela comunidade Java. Inclui um conjunto de especificações, como servlets, JSP, EJB, JPA, entre outros. O Java EE visa padronizar o desenvolvimento de aplicações empresariais, fornecendo APIs e contêineres para suporte a serviços como transações, segurança e persistência.

O Spring Framework, por outro lado, oferece uma abordagem alternativa e mais modular para o desenvolvimento de aplicações empresariais. Enquanto o Java EE tende a ser mais pesado e formal, o Spring é conhecido por sua flexibilidade e leveza. Ele permite que os desenvolvedores escolham apenas os componentes que precisam, sem a necessidade de adotar um contêiner de aplicação completo. Além disso, o Spring enfatiza a programação orientada a aspectos (AOP) e a injeção de dependências, o que pode resultar em um código mais limpo e de fácil manutenção.

### Conceito de Inversão de Controle

Inversão de Controle (IoC) é um princípio de design fundamental no Spring Framework. Refere-se a um padrão no qual o controle do fluxo de uma aplicação é invertido, ou seja, em vez de o programador definir explicitamente a sequência de chamadas e instâncias, o contêiner IoC do Spring assume essa responsabilidade.

No contexto do Spring, isso significa que o framework gerencia a criação e a injeção de dependências dos objetos, em vez de o próprio código da aplicação fazer isso. Isso resulta em uma arquitetura mais desacoplada e flexível, onde os componentes são mais facilmente testáveis e gerenciáveis.

### Injeção de Dependências

A Injeção de Dependências (DI) é um padrão de design que implementa o princípio da Inversão de Controle. DI permite que as dependências de um objeto sejam fornecidas em vez de serem criadas internamente. No Spring, isso é frequentemente feito através de anotação ou configuração XML.

Por exemplo, usando a anotação `@Autowired`, o Spring pode automaticamente injetar a dependência de um bean (componente gerenciado pelo Spring) em outro. Isso promove a reutilização de código e facilita a substituição de dependências durante os testes ou mudanças de requisitos.

### Beans, Autowired e Scopes

- **Beans**: No Spring, um bean é um objeto que é instanciado, montado e gerenciado pelo contêiner Spring. Beans são definidos na configuração da aplicação (via XML, anotações ou classes Java) e são fundamentais na estrutura do Spring.

- **Autowired**: A anotação `@Autowired` é usada para indicar que o Spring deve injetar automaticamente uma dependência em um bean. Pode ser aplicada a campos, setters e construtores. Por exemplo:
  ```java
  @Autowired
  private MyService myService;
  ```

- **Scopes**: Os escopos de beans definem o ciclo de vida e a visibilidade dos beans dentro da aplicação Spring. Os escopos mais comuns incluem:
  - **singleton**: (Padrão) Um único bean é criado para toda a aplicação.
  - **prototype**: Um novo bean é criado cada vez que é solicitado.
  - **request**: Um bean é criado para cada solicitação HTTP (aplicável em aplicações web).
  - **session**: Um bean é criado para cada sessão HTTP (aplicável em aplicações web).

### Projeto Spring Boot

Spring Boot é uma extensão do Spring Framework que simplifica o processo de criação e configuração de aplicações Spring. Ele oferece uma abordagem opinativa para a configuração, eliminando a necessidade de configuração XML ou Java complexa. Com o Spring Boot, os desenvolvedores podem criar rapidamente uma aplicação Spring pronta para produção com configuração mínima.

Principais características do Spring Boot incluem:

- **Auto configuração**: Spring Boot pode automaticamente configurar muitos componentes da aplicação com base nas dependências encontradas no classpath.
- **Starter POMs**: Pacotes predefinidos de dependências que simplificam a configuração do projeto.
- **Servidores embutidos**: Spring Boot permite que aplicações sejam executadas em servidores embutidos como Tomcat, Jetty ou Undertow, facilitando o desenvolvimento e o teste.
- **Actuator**: Um conjunto de ferramentas para monitorar e gerenciar a aplicação em produção.

Um exemplo de uma aplicação Spring Boot mínima seria:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
```

Neste exemplo, a anotação `@SpringBootApplication` combina várias anotações do Spring, incluindo `@Configuration`, `@EnableAutoConfiguration` e `@ComponentScan`, facilitando a configuração da aplicação.

## PROJETO SPRINGBOOT - Spring(boot) Framework
* O que é Springboot ?
* Configurações manuais
* Starters
* Principais Starters
*  Configuração de fábrica

### Springboot
Enquanto que o Spring Framework é baseado no padrão de injeção de dependências, o Springboot foca na configuração automática. Dado que a maior parte das configurações necessárias para o início de um projeto são sempre as mesmas, por que não iniciar um projeto com todas estas configurações já definidas? Essas definições são providas pelos starters (descritores de dependências).

## Antes do Springboot
Desafios com a configuração do projeto: 
* Dependência individual
* Verbosidade
* Incompatibilidade de versões
* Complexidade de gestão
* Configurações complexas e repetitivas

### Benefícios dos Starters no Spring Boot

Spring Boot revoluciona o desenvolvimento de aplicações Spring ao introduzir o conceito de "starters". Starters são pacotes predefinidos de dependências que simplificam e agilizam a configuração de projetos. Aqui estão os principais benefícios dos starters no Spring Boot:

#### Coesão

Os starters proporcionam uma coesão significativa ao agrupar dependências relacionadas em um único pacote. Cada starter é projetado para um propósito específico, como trabalhar com bancos de dados, serviços web ou segurança, garantindo que todas as dependências necessárias para uma funcionalidade específica sejam incluídas. Isso promove a coesão, pois os desenvolvedores podem adicionar facilmente funcionalidades completas à aplicação sem se preocupar com dependências fragmentadas.

Por exemplo, o starter `spring-boot-starter-web` inclui todas as dependências necessárias para desenvolver aplicações web, como Spring MVC, Jackson (para manipulação de JSON) e Tomcat (como servidor embutido).

#### Versões Compatíveis

Um dos maiores desafios no gerenciamento de dependências em projetos Java é garantir que todas as versões das bibliotecas sejam compatíveis entre si. Os starters do Spring Boot resolvem esse problema ao fornecer versões testadas e compatíveis das bibliotecas. Cada starter especifica versões de dependências que são conhecidas por funcionarem bem juntas, evitando conflitos de versões e problemas de compatibilidade.

#### Otimização do Tempo

Os starters economizam um tempo valioso no desenvolvimento ao eliminar a necessidade de configuração manual de dependências. Em vez de pesquisar e adicionar cada biblioteca necessária individualmente, os desenvolvedores podem simplesmente adicionar um starter ao arquivo de configuração do Maven ou Gradle. Isso reduz o tempo inicial de configuração e permite que os desenvolvedores comecem a codificar mais rapidamente.

Por exemplo, para começar a usar JPA (Java Persistence API) com Spring Data, basta adicionar o starter `spring-boot-starter-data-jpa`, que inclui todas as bibliotecas necessárias, como Hibernate, Spring Data JPA e um pool de conexões JDBC.

#### Configuração Simples

Além de gerenciar dependências, os starters também simplificam a configuração da aplicação. Com a configuração automática (auto-configuration) do Spring Boot, muitos aspectos da configuração são feitos automaticamente com base nas dependências presentes no classpath. Isso significa que, ao adicionar um starter, o Spring Boot pode configurar automaticamente os componentes necessários sem a necessidade de configuração adicional.

Por exemplo, ao adicionar `spring-boot-starter-security`, o Spring Boot configura automaticamente a segurança básica da aplicação, incluindo autenticação e autorização, com opções para personalização conforme necessário.

#### Foco no Negócio

Ao reduzir a complexidade da configuração e gerenciamento de dependências, os starters permitem que os desenvolvedores concentrem mais tempo e esforço no desenvolvimento da lógica de negócios da aplicação. Menos tempo é gasto configurando o ambiente e mais tempo é investido em criar funcionalidades que agregam valor ao negócio. Isso resulta em uma entrega mais rápida de valor para os stakeholders e em um desenvolvimento mais eficiente e produtivo.

### Exemplo Prático

Para ilustrar como os starters funcionam na prática, considere um exemplo simples de um projeto Spring Boot com funcionalidade web e JPA:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

Neste exemplo, os starters `spring-boot-starter-web` e `spring-boot-starter-data-jpa` incluem todas as dependências necessárias para criar uma aplicação web que interaja com um banco de dados utilizando JPA. Adicionando estas linhas no arquivo `pom.xml` ou `build.gradle`, o Spring Boot cuidará automaticamente da configuração de servidores web, suporte a JSON, JPA, transações e conexão com o banco de dados H2.

### Alguns Starters mais utilizados pela comunidade:
Spring-boot-starter-*
* data-jpa: Integração ao banco de dados via JPA - Hibernate.
* data-mongodb: Interação com banco de dados MongoDB.
* web: Inclusão do container Tomcat para aplicações REST.
* web-services: Webservices baseados na arquitetura SOAP. 
* batch: Implementação de JOBs de processos.
* test: Disponibilização de recursos para testes unitários como JUnit
* openfeign: Client HTTP baseado em interfaces
* actuator: Gerenciamento de monitoramento da aplicação. 

BEANS: CLASSES EXTERNAS (QUANDO NÃO HÁ ACESSO AO CÓDIGO-FONTE) QUE PRECISARÃO SER GERENCIADAS PELO SPRING;
COMPONENT: QUANDO É UMA CLASSE QUE TEM A POSSIBILIDADE E OBJETIVO DE SER PROVIDA ATRAVÉS DA INJEÇÃO DE DEPENDÊNCIAS;
