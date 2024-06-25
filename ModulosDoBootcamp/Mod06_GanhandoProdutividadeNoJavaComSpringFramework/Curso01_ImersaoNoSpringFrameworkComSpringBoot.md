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

### @Bean e @Component
No Spring Framework, tanto `@Bean` quanto `@Component` são usados para definir beans que o contêiner do Spring gerenciará, mas eles são usados em contextos diferentes e têm propósitos distintos.

### @Bean

A anotação `@Bean` é usada em métodos dentro de uma classe configurada com `@Configuration`. Esses métodos produzem beans que são geridos pelo contêiner Spring. A anotação `@Bean` é adequada para a criação de beans que requerem uma lógica de construção mais complexa ou que não podem ser automaticamente detectados pelo mecanismo de escaneamento de componentes.

**Quando usar `@Bean`:**

1. **Configuração Complexa**: Quando a criação do bean requer lógica adicional ou inicialização complexa que não pode ser realizada através de uma anotação simples em uma classe.
2. **Integração com Bibliotecas de Terceiros**: Quando você precisa configurar beans de bibliotecas externas que não podem ser anotados diretamente com `@Component`.
3. **Personalização Detalhada**: Quando você precisa personalizar a instância do bean de uma maneira que não pode ser facilmente alcançada através de anotações ou escaneamento automático.

**Exemplo:**

```java
@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("user");
        dataSource.setPassword("password");
        return dataSource;
    }
}
```

Neste exemplo, a criação e configuração do `DataSource` é complexa e personalizada, portanto, `@Bean` é a escolha adequada.

### @Component

A anotação `@Component` é usada diretamente em classes para marcá-las como beans Spring, permitindo que o contêiner Spring detecte e registre essas classes automaticamente através do escaneamento de componentes. `@Component` é uma anotação de nível de classe e é mais apropriada para classes que são de responsabilidade de um desenvolvedor e podem ser facilmente detectadas pelo Spring.

**Quando usar `@Component`:**

1. **Componentes Simples**: Quando a classe é um componente simples que não requer lógica complexa para sua instância.
2. **Serviços, Repositórios e Controladores**: É comum usar especializações de `@Component` como `@Service`, `@Repository` e `@Controller` para classificar e identificar o propósito da classe no contexto da aplicação.
3. **Escaneamento Automático**: Quando você deseja que o Spring encontre e registre automaticamente seus beans através do escaneamento de componentes.

**Exemplo:**

```java
@Component
public class MyService {

    public void performService() {
        // lógica do serviço
    }
}
```

Neste exemplo, `MyService` é um bean simples que pode ser detectado automaticamente pelo Spring.

**Uso de Especializações de `@Component`:**

- `@Service`: Usado para marcar uma classe de serviço.
- `@Repository`: Usado para marcar uma classe de repositório que interage com a base de dados.
- `@Controller`: Usado para marcar uma classe de controlador em uma aplicação web.

**Exemplo com Especializações:**

```java
@Service
public class UserService {
    // lógica de serviço para usuários
}

@Repository
public class UserRepository {
    // lógica de acesso a dados para usuários
}

@Controller
public class UserController {
    // lógica do controlador para gerenciar requisições HTTP
}
```

### Resumo

- Use `@Bean` quando precisar de controle total sobre a criação e configuração de um bean, especialmente quando trabalhar com bibliotecas externas ou configurações complexas.
- Use `@Component` (ou suas especializações `@Service`, `@Repository`, `@Controller`) quando sua classe for um componente da aplicação que pode ser facilmente detectado e registrado automaticamente pelo Spring.

### Escopos Singleton e Prototype no Spring Framework

No Spring Framework, o conceito de escopos define o ciclo de vida e a visibilidade dos beans geridos pelo contêiner Spring. Dois dos escopos mais comuns são o `singleton` e o `prototype`. Entender as diferenças entre eles é crucial para projetar uma aplicação eficiente e com comportamento previsível.

#### Escopo Singleton

**Definição:**

O escopo `singleton` é o padrão no Spring Framework. Quando um bean é definido como `singleton`, o contêiner Spring cria uma única instância desse bean e a compartilha em toda a aplicação. Isso significa que, independentemente de quantas vezes o bean seja solicitado, a mesma instância será retornada.

**Características:**

1. **Única Instância**: Apenas uma instância do bean é criada por contêiner Spring.
2. **Memória Compartilhada**: Todos os pontos da aplicação que dependem desse bean compartilharão a mesma instância.
3. **Gerenciamento Simplificado**: Facilita o gerenciamento de recursos compartilhados e a configuração centralizada.

**Vantagens:**

- **Eficiência de Recursos**: Economiza memória e tempo de inicialização, já que apenas uma instância é criada.
- **Consistência de Estado**: Permite a manutenção de um estado consistente através da aplicação, útil para beans que representam serviços ou repositórios.

**Desvantagens:**

- **Estado Compartilhado**: Pode levar a problemas de concorrência e estado compartilhado se não gerenciado corretamente.
- **Não Adequado para Estado Local**: Não é ideal para beans que precisam manter estados diferentes para cada usuário ou thread.

**Exemplo de Uso:**

```java
import org.springframework.stereotype.Service;

@Service
public class MySingletonService {
    // lógica do serviço
}
```

Neste exemplo, `MySingletonService` será gerido como um singleton. Cada vez que ele for solicitado, a mesma instância será retornada.

#### Escopo Prototype

**Definição:**

O escopo `prototype` cria uma nova instância do bean sempre que ele é solicitado. Ao contrário do escopo `singleton`, não há compartilhamento de instâncias entre os pontos da aplicação. Cada solicitação resulta em uma nova instância, proporcionando um comportamento diferente.

**Características:**

1. **Múltiplas Instâncias**: Uma nova instância é criada a cada solicitação.
2. **Isolamento de Estado**: Cada instância é independente, o que elimina problemas de concorrência e estado compartilhado.
3. **Uso Dinâmico**: Adequado para beans que necessitam de configuração dinâmica ou estado independente.

**Vantagens:**

- **Isolamento de Estado**: Ideal para componentes que precisam manter estados distintos por solicitação ou thread.
- **Flexibilidade**: Permite maior flexibilidade na configuração e uso de beans, especialmente quando diferentes instâncias necessitam de diferentes estados.

**Desvantagens:**

- **Consumo de Recursos**: Pode consumir mais memória e tempo de inicialização, já que novas instâncias são constantemente criadas.
- **Gerenciamento de Ciclo de Vida**: Mais complexo, pois o desenvolvedor precisa gerenciar explicitamente o ciclo de vida e a destruição dos beans.

**Exemplo de Uso:**

```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyPrototypeBean {
    // lógica do bean
}
```

Neste exemplo, `MyPrototypeBean` será gerido como um prototype. Cada vez que ele for solicitado, uma nova instância será criada.

### Considerações Práticas

Ao escolher entre `singleton` e `prototype`, considere os seguintes aspectos:

- **Necessidade de Estado Compartilhado**: Use `singleton` se os beans precisam compartilhar estado e recursos através da aplicação.
- **Isolamento e Independência**: Use `prototype` se cada solicitação deve resultar em uma instância independente com seu próprio estado.
- **Consumo de Recursos**: `singleton` é mais eficiente em termos de recursos, enquanto `prototype` pode resultar em maior consumo de memória e tempo de criação.

### Conclusão

O escopo `singleton` é ideal para beans que representam serviços e repositórios compartilhados, proporcionando eficiência e consistência de estado. O escopo `prototype` é mais adequado para beans que precisam de isolamento de estado e instâncias independentes, oferecendo maior flexibilidade e dinamismo. Ao compreender as diferenças e aplicações desses escopos, você pode tomar decisões informadas para projetar uma arquitetura Spring que seja eficiente, escalável e adequada às necessidades específicas de sua aplicação.

### Uso de `@Value` em Spring para Injeção de Propriedades

No Spring Framework, a anotação `@Value` é usada para injetar valores de propriedades em campos, métodos ou parâmetros de construtor. Isso permite a externalização de configurações, facilitando a gestão e a mudança de valores de configuração sem a necessidade de recompilar o código. Esses valores podem ser extraídos de arquivos de propriedades (`.properties`), arquivos YAML (`.yml`), variáveis de ambiente ou argumentos de linha de comando.

### Como Usar `@Value`

A anotação `@Value` é geralmente usada em combinação com arquivos de propriedades (`application.properties` ou `application.yml`). Aqui está uma explicação detalhada de como usá-la:

#### Injeção de Valores Simples

Você pode injetar valores simples diretamente em campos da classe.

**Exemplo com `application.properties`:**

1. **Definindo Propriedades**:
    ```properties
    # application.properties
    app.name=MinhaAplicacao
    app.version=1.0.0
    ```

2. **Injetando Propriedades**:
    ```java
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Component;

    @Component
    public class AppConfig {

        @Value("${app.name}")
        private String appName;

        @Value("${app.version}")
        private String appVersion;

        public void printAppInfo() {
            System.out.println("App Name: " + appName);
            System.out.println("App Version: " + appVersion);
        }
    }
    ```

Neste exemplo, os valores das propriedades `app.name` e `app.version` são injetados nos campos `appName` e `appVersion` da classe `AppConfig`.

#### Injeção em Métodos e Construtores

Você também pode usar `@Value` para injetar valores em métodos ou parâmetros de construtores.

**Exemplo com Método:**
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    private String appName;

    @Value("${app.name}")
    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void printAppInfo() {
        System.out.println("App Name: " + appName);
    }
}
```

**Exemplo com Construtor:**
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    private final String appName;

    public AppConfig(@Value("${app.name}") String appName) {
        this.appName = appName;
    }

    public void printAppInfo() {
        System.out.println("App Name: " + appName);
    }
}
```

### Usando com Arquivos YAML

Além de arquivos de propriedades, você pode usar arquivos YAML (`application.yml`) para definir propriedades.

**Exemplo com `application.yml`:**

1. **Definindo Propriedades**:
    ```yaml
    # application.yml
    app:
      name: MinhaAplicacao
      version: 1.0.0
    ```

2. **Injetando Propriedades**:
    ```java
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Component;

    @Component
    public class AppConfig {

        @Value("${app.name}")
        private String appName;

        @Value("${app.version}")
        private String appVersion;

        public void printAppInfo() {
            System.out.println("App Name: " + appName);
            System.out.println("App Version: " + appVersion);
        }
    }
    ```

### Manipulação de Tipos Diferentes

O Spring é capaz de converter automaticamente valores de propriedades para o tipo adequado, desde que o valor possa ser convertido.

**Exemplo com Tipos Diferentes:**

```properties
# application.properties
app.port=8080
app.active=true
```

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${app.port}")
    private int port;

    @Value("${app.active}")
    private boolean active;

    public void printAppConfig() {
        System.out.println("App Port: " + port);
        System.out.println("App Active: " + active);
    }
}
```

### Valores Padrão

Você pode fornecer valores padrão caso a propriedade não esteja definida.

**Exemplo com Valores Padrão:**

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${app.name:AplicacaoDefault}")
    private String appName;

    public void printAppInfo() {
        System.out.println("App Name: " + appName);
    }
}
```

Neste exemplo, se a propriedade `app.name` não estiver definida, `appName` será definido como `AplicacaoDefault`.

### Conclusão

A anotação `@Value` no Spring Framework é uma ferramenta poderosa para injetar valores de propriedades em seus componentes, promovendo uma configuração flexível e fácil de gerenciar. Ao externalizar a configuração, você pode ajustar os valores sem recompilar o código, facilitando a manutenção e a adaptabilidade da aplicação a diferentes ambientes. Ao compreender e utilizar `@Value`, você pode criar aplicações mais configuráveis e adaptáveis às necessidades específicas do seu projeto.