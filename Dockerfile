FROM openjdk:21-jdk-slim

# Instalando o Maven
RUN apt-get update && apt-get install -y maven && apt-get clean

# Adicionando um grupo e usuário não-root com UID e GID correspondentes ao host
ARG USER_ID=1000
ARG GROUP_ID=1000

# Adicione este comando para depuração
RUN echo "USER_ID=${USER_ID}, GROUP_ID=${GROUP_ID}"

RUN groupadd -g ${GROUP_ID} mygroup && \
    useradd -u ${USER_ID} -g mygroup -m myuser

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copiando o arquivo pom.xml com as permissões corretas
COPY --chown=myuser:mygroup pom.xml ./

# Copiando o restante do código fonte
COPY --chown=myuser:mygroup src ./src

# Alterando a propriedade do diretório /app para myuser:mygroup
RUN chown -R myuser:mygroup /app

# Mudando para o usuário não-root
USER myuser

# Criando o diretório .m2 e ajustando permissões
RUN mkdir -p /home/myuser/.m2 && \
    chown -R myuser:mygroup /home/myuser/.m2

# Garantindo que o diretório target/classes existe e tem permissões corretas
RUN mkdir -p /app/target/classes && \
    chmod -R u+w /app/target/classes

# Baixando as dependências (para evitar baixar dependências toda vez)
RUN mvn dependency:go-offline

# Expondo a porta em que o Spring Boot estará rodando (default 8080)
EXPOSE 8080

# Comando para rodar a aplicação (temporariamente mantido o container ativo)
CMD ["tail", "-f", "/dev/null"]

# # Comando alternativo para iniciar a aplicação baseado no ambiente
# ARG ENV=dev
# ENV SPRING_PROFILES_ACTIVE=$ENV
# EXPOSE 8080
# CMD ["sh", "-c", "if [ \"$SPRING_PROFILES_ACTIVE\" = \"prod\" ]; then java -jar /app/portfolioai.jar; else tail -f /dev/null; fi"]