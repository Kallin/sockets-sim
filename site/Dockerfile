FROM node:4.1

RUN npm install harp -g

VOLUME ["/input", "/output"]

ADD . /input

WORKDIR /input

ENTRYPOINT ["harp"]

CMD ["--help"]
