# Positive Chat 
Positive Chat è un progetto universitario che usa delle tecnologie studiate nella materia Technologies for Advanced Programming del corso di Informatica L-31 dell'Università degli Studi di Catania.

## Obiettivo 
L'obiettivo finale di tale servizio (o insieme di servizi, vedremo più avanti) è rendere una chat totalmente positiva. Che significa? Oggi giorno, Internet è diventato un posto sempre più negativo, in particolare con la diffusione di servizi di messaggistica istantanea, ancor più se queste chat sono di gruppo. Il [flame](https://www.urbandictionary.com/define.php?term=flame) regna sovrano e probabilmente nel mondo serve un gruppo **Positive** 

## Tecnologie usate
Le tecnologie che sono state usate in questo progetto sono:
| Step | Technology used |
| :---- | :---------------: |
| **Data ingestion** | [Apache Kafka Connect](https://kafka.apache.org/documentation.html#connect) |
| **Data streaming** | [Apache Kafka](https://kafka.apache.org/) / [Apache Spark Streaming](https://spark.apache.org/streaming/) |
| **Data processing** | [Apache Spark](https://spark.apache.org/) / [Apache Spark MLlib](https://spark.apache.org/mllib/) |
| **Data indexing** | [ElasticSearch](https://www.elastic.co/) |
| **Data visualization** | [Kibana](https://www.elastic.co/kibana) |

## Architettura
<br><img src="./docs/img/ArchitetturaPositive.png"/>

## Requisiti
1. Docker - [install](https://docs.docker.com/engine/install/)
2. Docker Compose - [install](https://docs.docker.com/compose/install/)

## Guida all'installazione
1. Clone this repositoriy  `git clone https://github.com/Pierpaolo791/TAP-PositiveChat-Project.git`
2. Download [Apache Kafka](https://github.com/Pierpaolo791/TAP-PositiveChat-Project/raw/master/kafka/setup/kafka_2.12-2.5.0.tgz) in kafka/setup
3. Download [Apache Spark](https://github.com/Pierpaolo791/TAP-PositiveChat-Project/raw/master/Spark/spark-3.0.0-bin-hadoop2.7.tgz) in Spark

### Comandi da lanciare
```
# Nella directory che contiene docker-compose.yml
$ docker-compose up zookeeper 
$ docker-compose up elasticsearch
$ docker-compose up kafka-server
$ docker-compose up kibana
$ docker-compose up spark
$ docker-compose up positive-ingestor
```

## Credit
Pierpaolo Pecoraio


