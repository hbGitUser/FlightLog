package flightLog.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flightLog.FlightLog;
import flightLog.entities.Pilot;

public class FlightLogBookCtrl extends HttpServlet {
   private static final long serialVersionUID = -5382691079422638029L;

   private static final String JSP_FLIGHT_LOG_CTRL = "/FlightLogCtrl.jsp";
   private static final String JSP_FLIGHT_LOG_DB = "/FlightLogDb.jsp";
   private static final String JSP_PILOT_DETAIL = "/PilotDetail.jsp";
   private static final String JSP_PILOT_DISPLAY = "/PilotDisplay.jsp";
   private static final String JSP_PILOT_SEARCH = "/PilotSearch.jsp";
   private static final String JSP_PILOT_LIST = "/pilots.jsp";
   private static final String JSP_FLIGHT_LIST = "/flights.jsp";

   public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String forward = handleRequest(request, response);
      RequestDispatcher view = request.getRequestDispatcher(forward);
      view.forward(request, response);
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      doGet(request, response);
   }

   private String handleRequest(HttpServletRequest request,
            HttpServletResponse response) {
      String forward = "";
      Map<String, String[]> reqParmMap = request.getParameterMap();
      if (request.getAttribute("msg") != null) {
         request.removeAttribute("msg");
      }
//      String oldDbFileName = (String) request.getAttribute("dbFileName");
//      String newDbFileName = (reqParmMap.containsKey("dbFileName")) ? reqParmMap
//               .get("dbFileName")[0]
//               : null;
//      if ((newDbFileName == null || (newDbFileName != null
//               && (newDbFileName.length() == 0) || (newDbFileName.length() > 0 && !newDbFileName
//               .equals(oldDbFileName))))
//               && (oldDbFileName != null && oldDbFileName.length() > 0)) {
//         FlightLog flbI = new FlightLog();
//         if (request.getAttribute("msg") != null) {
//            request.removeAttribute("msg");
//         }
//         String dbFileName = null;
//         if ((oldDbFileName == null && newDbFileName != null)
//                  || (oldDbFileName != null && newDbFileName != null && !oldDbFileName
//                           .equals(newDbFileName))) {
//            dbFileName = newDbFileName;
//         } else {
//            dbFileName = oldDbFileName;
//         }
         try {
////            flbI.setDbFileName(dbFileName);
//            request.setAttribute("dbFileName", dbFileName);
            forward = handleDetailFunctions(request, response, reqParmMap);
         } catch (Exception e) {
            forward = JSP_FLIGHT_LOG_DB;
            request.setAttribute("msg", e.getLocalizedMessage());
         }
//
//      } else {
//         forward = JSP_FLIGHT_LOG_DB;
//         request.setAttribute("msg", "Datenbankpfad und -name fehlt!");
//      }
      return forward;
   }

   private String handleDetailFunctions(HttpServletRequest request,
            HttpServletResponse response, Map<String, String[]> reqParmMap)
            throws Exception {
      String forward = "";
      FlightLog flbI = new FlightLog();
      if (reqParmMap.containsKey("create")) {
         forward = JSP_PILOT_DETAIL;
      } else if (reqParmMap.containsKey("ctrl")) {
         forward = JSP_FLIGHT_LOG_CTRL;
         if (request.getAttribute("msg") != null) {
            request.removeAttribute("msg");
         }
      } else if (reqParmMap.containsKey("delete")) {
         forward = JSP_PILOT_DETAIL;
         request.setAttribute("surname", reqParmMap.get("surname")[0]);
         request.setAttribute("forename", reqParmMap.get("forename")[0]);
//         Pilot pilotDelete = new Pilot(reqParmMap.get("surname")[0], reqParmMap.get("forename")[0]);
         try {
//            pilotDelete = flbI.deletePilot(pilotDelete);
            request.setAttribute("msg", "Gelšscht!");
         } catch (Exception e) {
            request.setAttribute("msg", e.getLocalizedMessage());
         }
      } else if (reqParmMap.containsKey("detail")
               || reqParmMap.containsKey("display")
               || reqParmMap.containsKey("save")) {
//         Pilot pilotSearch = new Pilot(reqParmMap.get("surname")[0], reqParmMap.get("forename")[0]);
         Pilot pilotSearch = null;
         try {
            List<Pilot> pilotsFound = flbI.getPilots(pilotSearch);
            if (pilotsFound != null && pilotsFound.size() <= 1) {
               if (pilotsFound.size() == 1) {
                  Pilot pilotFound = pilotsFound.get(0);
                  request.setAttribute("surname", reqParmMap.get("surname")[0]);
                  request.setAttribute("forename",
                           reqParmMap.get("forename")[0]);
                  request.setAttribute("medical", pilotFound.getMedical());
                  request.setAttribute("radioComLicence", pilotFound
                           .getRadioComLicence());
                  if (reqParmMap.containsKey("save")) {
                     forward = JSP_PILOT_DETAIL;
                     request.setAttribute("msg", "Bereits vorhanden!");
                  } else {
                     if (request.getAttribute("msg") != null) {
                        request.removeAttribute("msg");
                     }
                     if (reqParmMap.containsKey("detail")) {
                        forward = JSP_PILOT_DETAIL;
                     } else if (reqParmMap.containsKey("display")) {
                        forward = JSP_PILOT_DISPLAY;
                     }
                  }
               } else {
                  request.setAttribute("surname", reqParmMap.get("surname")[0]);
                  request.setAttribute("forename",
                           reqParmMap.get("forename")[0]);
                  if (reqParmMap.containsKey("save")) {
                     forward = JSP_PILOT_DETAIL;
                     request.setAttribute("medical",
                              reqParmMap.get("medical")[0]);
                     request.setAttribute("radioComLicence", reqParmMap
                              .get("radioComLicence")[0]);
                     //ah
                     Pilot pilot = new Pilot(new Long(reqParmMap.get("id")[0]),
                    		 reqParmMap.get("surname")[0],
                              reqParmMap.get("forename")[0], reqParmMap
                                       .get("medical")[0], reqParmMap
                                       .get("radioComLicence")[0]);
                     try {
                        pilot = flbI.savePilot(pilot);
                        request.setAttribute("msg", "Gespeichert!");
                     } catch (Exception e) {
                        request.setAttribute("msg", "Fehler beim Speichern!");
                     }
                  } else {
                     forward = JSP_PILOT_SEARCH;
                     request.setAttribute("msg", "Nicht gefunden!");
                  }
               }
            } else {
               forward = JSP_PILOT_SEARCH;
               request.setAttribute("msg", "Mehr als ein Pilot gefunden!");
            }
         } catch (Exception e) {
            forward = JSP_PILOT_SEARCH;
            request.setAttribute("msg", e.getLocalizedMessage());
         }
      } else if (reqParmMap.containsKey("search")) {
         forward = JSP_PILOT_SEARCH;
      } else if (reqParmMap.containsKey("createDb")) {
         forward = JSP_FLIGHT_LOG_CTRL;
         if (request.getAttribute("msg") != null) {
            request.removeAttribute("msg");
         }
      } else {
         forward = JSP_FLIGHT_LOG_CTRL;
         request.setAttribute("msg", "Unbekannte Funktion!");
      }
      return forward;
   }
}
