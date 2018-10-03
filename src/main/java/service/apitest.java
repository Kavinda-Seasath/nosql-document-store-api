package service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.xdevapi.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/v1/api")
public class apitest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test1() {
        return "Testing zero";
    }

    /*@Path("/find")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDocumentdata() throws Exception {

        String returnData = null;
        Session mySession = null;

        try {

            mySession = new SessionFactory().getSession("mysqlx://localhost:33060/nosqltest?user=root&password=root");

            Schema myDb = mySession.getSchema("nosqltest");
            Collection myColl = myDb.createCollection("my_collection", true);
            System.out.println("checking");
            DocResult docs = myColl.find().execute();
            //System.out.println(docs.fetchAll());
            List<DbDoc> array = docs.fetchAll();

            //System.out.println(returnData);

            Gson gson = new GsonBuilder().create();
            returnData = gson.toJson(array);

            //System.out.println(abc);

            return returnData;



        } catch (Exception e) {

            return e.toString();
        }
        finally {
            if (mySession != null){
                mySession.close();
            }
        }

        //return returnData;
    }*/


    //usage of api example -: http://localhost:8080/rest/v1/api/findvalue?date=2018-09-07&status=2 (only a instant of finding)

    @Path("/findvalue")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDocumentdata(@DefaultValue("") @QueryParam("date") String date, @QueryParam("status") int status) throws Exception {

        String returnData = null;
        Session mySession = null;

        try {

            mySession = new SessionFactory().getSession("mysqlx://localhost:33060/nosqltest?user=root&password=root");

            Schema myDb = mySession.getSchema("nosqltest");
            Collection myColl = myDb.createCollection("my_collection", true);
            System.out.println("checking");
            DocResult docs = myColl.find("dateof like :d AND status like :status").bind("d",date+"%").bind("status",status).execute();
            //System.out.println(docs.fetchAll());
            List<DbDoc> array = docs.fetchAll();

            //System.out.println(returnData);

            Gson gson = new GsonBuilder().create();
            returnData = gson.toJson(array);

            //System.out.println(abc);

            return returnData;



        } catch (Exception e) {

            return e.toString();
        }
        finally {
            if (mySession != null){
                mySession.close();
            }
        }

        //return returnData;
    }

}
