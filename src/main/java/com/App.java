package com;

import com.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.xdevapi.*;

import java.text.SimpleDateFormat;
import java.util.Date;


public class App {
    public static void main(String[] args) {

        data obj = new data();

        Date today = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat ("yyyy-MM-dd");

        obj.setAge(27);
        obj.setEmail("directfn@outlook.com");
        obj.setName("testing5");
        obj.setStatus(2);
        obj.setDateof(fmt.format(today));
        obj.set_id(fmt.format(today));


        //System.out.println(fmt.format(today));


        Gson gson = new GsonBuilder().create();
        String jsondoc = gson.toJson(obj);
        //System.out.println(jsondoc);



        // Connect to server on localhost
        Session mySession = new SessionFactory().getSession("mysqlx://localhost:33060/nosqltest?user=root&password=root");

        Schema myDb = mySession.getSchema("nosqltest");
        Collection myColl = myDb.createCollection("my_collection",true);

        //adding json string to mysql document store
        //myColl.add(jsondoc).execute();

        //three different find queries to retrieve data from database
        //DocResult docs = myColl.find().execute();
        //DocResult docs = myColl.find("dateof like :d"  ).bind("d","2018-09-05").execute();
        DocResult docs = myColl.find("dateof like :d AND status like :status").bind("d","2018-09-05").bind("status",2).execute();

        //String aaa = gson.toJson(docs);
        //System.out.println(aaa );
        while (docs.hasNext()) {
            DbDoc mydoc = docs.next();
            System.out.println(mydoc);
        }

/*      deleting the document collection
        myDb.dropCollection("my_collection");
*/
        //mySession.close();
    }
}
