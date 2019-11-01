import groovy.sql.Sql

def db = Sql.newInstance("jdbc:postgresql://127.0.0.1:54326/ark", "postgres", "password", "org.postgresql.Driver")


println(db.firstRow("select 1"))
