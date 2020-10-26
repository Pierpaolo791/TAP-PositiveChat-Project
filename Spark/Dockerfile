FROM maven:latest

ENV SPARK_VERSION=3.0.0
ENV SPARK_DIR=/opt/spark
ENV PATH $SPARK_DIR/bin:$PATH
ENV POSITIVE_SPARK_STREAMING "positive-spark-streaming"
ENV POSITIVE_SPARK_DIR "/opt/spark/"

ADD spark-${SPARK_VERSION}-bin-hadoop2.7.tgz /opt
RUN ln -s /opt/spark-${SPARK_VERSION}-bin-hadoop2.7 ${SPARK_DIR} 

COPY ${POSITIVE_SPARK_STREAMING} ${POSITIVE_SPARK_DIR}
WORKDIR ${POSITIVE_SPARK_DIR}
RUN mvn package
RUN cp target/positive* ${POSITIVE_SPARK_DIR}


COPY spark-starter.sh ${POSITIVE_SPARK_DIR}
WORKDIR ${POSITIVE_SPARK_DIR} 
#CMD sleep 3900s
CMD ./spark-starter.sh

