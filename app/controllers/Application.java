package controllers;

import org.reflections.Store;
import play.data.DynamicForm;
import play.data.Form;
import views.html.*;
import models.*;
import play.mvc.*;
import play.api.templates.Html;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Application extends Controller {

    public static List<ram> ramList = new ArrayList<ram>();

    public static List<iphone> iphoneList;

    public static Form<pcdesktop> pcdesktopForm = Form.form(pcdesktop.class);
    public static pcdesktop newpc;
    public static List<pcdesktop> pcdesktopList = new ArrayList<pcdesktop>();

    static {
        pcdesktopList.add(new pcdesktop("boy","boy","boy","boy","boy","boy","boy",1.00,5000.00,5.00));
        pcdesktopList.add(new pcdesktop("boy","boy","boy","boy","boy","boy","boy",1.00,5000.00,5.00));
    }

    public  static  Result home(Html content,String pagename){
        return  ok(views.html.shows.render(content,pagename));
    }

    public static Result Storeview() {
        inside StoreData = new inside();
        StoreData.setStorename("Phongsakorn");
        StoreData.setStore_address("KhonKaen");
        StoreData.setStore_type("Everyday Product");

        StoreData.setStore_phone("089-7654321");
        StoreData.setStore_opendate("01/02/2555");
        StoreData.setStore_size(200);
        StoreData.setStore_openofweek(5);
        return home(Storeview.render(StoreData),"Storeview");
    }

    public static Result index() {
        return home(aboutme.render(),"index");
    }

    public static  Result product() {
        pcdesktop Desktop = new pcdesktop();
        Desktop.setPrecount(1.0);
        Desktop.setPrice(6000.00);
        Desktop.setDiscount(10.00);
        return home(product.render(Desktop),"product");
    }

    public static Result showsdata(){
        return  home(showsdata.render(pcdesktopList),"showsdata");
    }

    public static Result inputstore(){
        return home(inputstore.render(),"inputstore");
    }

     public static Result putstore() {
        DynamicForm dynaForm = Form.form().bindFromRequest();
        pcdesktop newpc = new pcdesktop();
        /* String Storename,Storeaddress,Storetype; */
        /* Storename = dynaForm.get("Storename");
        Storeaddress = dynaForm.get("Storeaddress");
        Storetype = dynaForm.get("Storetype");
        newstore.setStore_address(Storeaddress);
        newstore.setStore_type(Storetype);
        newstore.setStorename(Storename); */
         newpc.setBrand(dynaForm.get("brand"));
        newpc.setMainboard(dynaForm.get("mainboard"));
        newpc.setCpu(dynaForm.get("cpu"));
        newpc.setRam(dynaForm.get("ram"));
         newpc.setStorage(dynaForm.get("storage"));
         newpc.setPsu(dynaForm.get("psu"));
         newpc.setPccase(dynaForm.get("pccase"));
         newpc.setPrecount(Double.parseDouble(dynaForm.get("count")));
         newpc.setPrice(Double.parseDouble(dynaForm.get("price")));
         newpc.setDiscount(Double.parseDouble(dynaForm.get("discount")));
        pcdesktopList.add(newpc);
        return showsdata();
    }

    public static  Result inputHelper() {
        return home(inputstoreHelper.render(pcdesktopForm),"inputHelper");
    }

    public static  Result frmupload() {
        return home(fileupload.render(),"frmupload");
    }

    public static  Result frmuploadmult() {
        return home(mufileupload.render(),"mufrmupload");
    }

    public static  Result upload() {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        if(body == null) {
            flash("error","Error! Cannot upload files");
            return frmupload();
        }

        Http.MultipartFormData.FilePart filePart = body.getFile("file");
        if (filePart == null) {
            flash("error","Error! Cannot upload files");
            return frmupload();
        } else {
            String postPicPath="public/images/uploads/";
            String fileName= filePart.getFilename();
            //String contentType = filePart.getContentType();
            File file = filePart.getFile();
            try {
                file.renameTo(new File(postPicPath,fileName));
            } catch (Exception ex) {
                flash("error","Error! Cannot upload files");
                return frmupload();
            }
        }
        return ok("Upload successed, file =>"+ filePart.getFilename());
    }

    public static Result uploadmult() {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        if(body == null)
        {
            flash("error", "Error! Cannot upload files...");
            return frmuploadmult();
        }

        List<Http.MultipartFormData.FilePart> fileParts = body.getFiles();
        if(fileParts.isEmpty())
        {
            flash("error", "Error! Cannot upload files...");
            return frmuploadmult();
        }
        int i=0;
        String fName= "";
        Random ran = new Random();
        String id ;
        for(Http.MultipartFormData.FilePart filePart: fileParts) {
            i++;
            try
            {
                id = Integer.toString(ran.nextInt(100000));
                File file = filePart.getFile();
                String filename = id+filePart.getFilename();
                String postPicPath="public/images/uploads/";
                file.renameTo(new File(postPicPath, filename));
                fName = fName + filename + ", ";
            } catch(Exception ex) {
                flash("error", "Error! Cannot upload files...");
                return frmuploadmult();
            }

        }
        return ok("Upload Success: " + i + " files=> " + fName);
    }

    public static  Result poststoreHelper() {

        Form<pcdesktop> newpcf = pcdesktopForm.bindFromRequest();

        if(newpcf.hasErrors()){
            flash("msgerror","ท่านป้อนข้อมูลไม่ถูกต้อง");
            return ok(newpcf.errorsAsJson());
        }else{
            newpc = newpcf.get();
            pcdesktopList.add(newpc);
            return showsdata();
        }

    }

    public static Result frmram() {
        return home(ramupload.render(),"ramupload");
    }

    public static  Result uploadram() {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        if(body == null) {
            flash("error","Error! Cannot upload files");
            return frmupload();
        }

        Http.MultipartFormData.FilePart filePart = body.getFile("file");
        if (filePart == null) {
            flash("error","Error! Cannot upload files");
            return frmupload();
        } else {
            String postPicPath="public/images/uploads/";
            String fileName= filePart.getFilename();
            //String contentType = filePart.getContentType();
            File file = filePart.getFile();
            try {
                file.renameTo(new File(postPicPath,fileName));
            } catch (Exception ex) {
                flash("error","Error! Cannot upload files");
                return frmupload();
            }
        }
        DynamicForm dynaForm = Form.form().bindFromRequest();
        ram newram = new ram();
        newram.setBrand(dynaForm.get("brand"));
        newram.setBus(dynaForm.get("bus"));
        newram.setChips(dynaForm.get("chips"));
        newram.setMesize(dynaForm.get("mesize"));
        newram.setImg(filePart.getFilename());
        ramList.add(newram);
        return showsram();
    }

    public static Result showsram(){
        return  home(showsram.render(ramList),"showsram");
    }

    public static Result showsjohncena(){
        iphoneList = iphone.list();
        return  home(showsjohncena.render(iphoneList),"showsjohncena");
    }
}
