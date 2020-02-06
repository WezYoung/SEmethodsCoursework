# Use the latest MySQL image
FROM mysql
# set working directory
WORKDIR /tmp
# Copy the main SQL file to docker-entrypoint-initdb.d
COPY world.sql /tmp/
COPY world.sql /docker-entrypoint-initdb.d
# set the root password
ENV MYSQL_ROOT_PASSWORD example




