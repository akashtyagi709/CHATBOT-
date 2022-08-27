package com.company;

import spark.ModelAndView;
import spark.Spark;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Spark.staticFileLocation("public_html");

        Spark.get("/",(request,response)->{

            HashMap<String, Object> model = new HashMap<>();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "index"));
        });

        Spark.get("/chat",(request,response)-> {
            HashMap<String, Object> model= new HashMap<>();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "chat_window"));
        });

        Spark.post("/chat", (request, response)-> {

           String choice= request.queryParams("choice");
           if("appointment".equals(choice)){
               return "<div>" +
                       "Choose Location of Hospital:"+
                       "<a onclick=\"submitChoice(this)\" data-choice=\"search1\" class=\"choice\">Meerut </a>" +
                       "<a onclick=\"submitChoice(this)\" data-choice=\"search2\" class=\"choice\">Noida </a>" +
                       "</div>";
           }
            if("faqs".equals(choice)){
               return
                       "<div>Help Desk:</div>"+
                       "<div>Contact No:1389-6789</div>"+
                               "<div>Website:<a href=\"#\" class=\"stretched-link\">www.hospital org.com</a></div>"+
                               "<div>Mail:hospital_12@org.com</div>";

           }
            if("search1".equals(choice)){
               return"<div>"+
                       "For Meerut Hospitals:"+
                           "<a onclick=\"submitChoice(this)\" data-choice=\"search4\" class=\"choice\">Need Appointment</a>"+
                       "<a onclick=\"submitChoice(this)\" data-choice=\"search5\" class=\"choice\"> Follow Up</a>"+
                      " </div>";
            }
            if("search2".equals(choice)){
                return"<div>"+
                        "For Noida Hospitals:"+
                        "<a onclick=\"submitChoice(this)\" data-choice=\"search6\" class=\"choice\">Need Appointment</a>"+
                        "<a onclick=\"submitChoice(this)\" data-choice=\"search5\" class=\"choice\"> Follow Up</a>"+
                        " </div>";
            }
            if("search4".equals(choice)) {
                return "<div>" +
                        "Choose Appointment Type:"+
                        "<a onclick=\"submitChoice(this)\" data-choice=\"car\" class=\"choice\">Cardiologist </a>" +
                        "<a onclick=\"submitChoice(this)\" data-choice=\"onco\" class=\"choice\">Oncologist </a>" +
                        "<a onclick=\"submitChoice(this)\" data-choice=\"ortho\" class=\"choice\">Orthopedic </a>"+
                        "</div>";
           }
            if("search5".equals(choice)) {
               return "<div>" +
                       "<div>Follow Up:</div>"+
                       "Dr. Gupta available from 9am to 10pm for your follow up processor except Saturday and Sunday " +
                       "<div>For emergency case contact us on" + "<a onclick=\"submitChoice(this)\" data-choice=\"faqs\" class=\"choice\">FAQs</a>\n</div>" +
                       "</div>";
           }
            if("car".equals(choice)) {
                return "<div>" +
                        "Choose a cardiologist:"+
                        "<a onclick=\"submitChoice(this)\" data-choice=\"awasthi\" class=\"choice\">Dr Awasthi </a>" +
                        "<a onclick=\"submitChoice(this)\" data-choice=\"gupta\" class=\"choice\">Dr Gupta </a>" +
                        "</div>";
            }

            if("awasthi".equals(choice)){

                return"<div>" +
                        "You can visit for Dr Awasthi from Monday to Friday"+
                        "<div>For emergency case contact us on"+"  <a onclick=\"submitChoice(this)\" data-choice=\"faqs\" class=\"choice\">FAQs</a>\n</div>"+
                        "</div>";
            }

            if("gupta".equals(choice)){
                return"<div>" +
                        "You can visit for Dr Gupta from Monday to Friday"+
                        "<div>For emergency case contact us on"+"  <a onclick=\"submitChoice(this)\" data-choice=\"faqs\" class=\"choice\">FAQs</a>\n</div>"+
                        "</div>";
            }
            if("onco".equals(choice)) {
                return "<div>" +
                        "Select an oncologist:"+
                        "<a onclick=\"submitChoice(this)\" data-choice=\"ani\" class=\"choice\">Dr Anirudh</a>" +
                        "<a onclick=\"submitChoice(this)\" data-choice=\"pandey\" class=\"choice\">Dr Pandey </a>" +
                        "</div>";
            }
            if("ortho".equals(choice)) {
                return"<div>" +
                        "If you are looking for an orthopedic:"+
                        "You can visit on Monday and Wednesday"+
                        "<div>For emergency case contact us on"+"  <a onclick=\"submitChoice(this)\" data-choice=\"faqs\" class=\"choice\">FAQs</a>\n</div>"+
                        "</div>";
            }
            if("ani".equals(choice)) {
                return"<div>" +
                        "You can visit for Dr Anirudh on Monday and Wednesday"+
                        "<div>For emergency case contact us on"+"  <a onclick=\"submitChoice(this)\" data-choice=\"faqs\" class=\"choice\">FAQs</a>\n</div>"+
                        "</div>";
            }
            if("pandey".equals(choice)) {
                return"<div>" +
                        "You can visit for Dr Pandey from Monday to Thursday from 9am to 9pm"+
                        "<div>For emergency case contact us on"+"  <a onclick=\"submitChoice(this)\" data-choice=\"faqs\" class=\"choice\">FAQs</a>\n</div>"+
                        "</div>";
            }
            if("search6".equals(choice)) {
                return "<div>" +
                        "Choose Appointment Type:"+
                        "<a onclick=\"submitChoice(this)\" data-choice=\"car\" class=\"choice\">Cardiologist </a>" +
                        "<a onclick=\"submitChoice(this)\" data-choice=\"onco\" class=\"choice\">Oncologist </a>" +
                        "<a onclick=\"submitChoice(this)\" data-choice=\"ortho\" class=\"choice\">Orthopedic </a>"+
                        "</div>";
            }


             return"<div> I dont understand</div>";
       });
    }
}
