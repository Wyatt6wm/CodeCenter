FROM wyatt6/ubuntu20-jdk17
ENV VERSION 1.0.0
WORKDIR /home/wyatt
ADD ./target/code-center.v${VERSION}.jar ./
CMD java -jar ./code-center.v${VERSION}.jar