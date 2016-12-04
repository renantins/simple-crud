package br.com.renan.control;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renan.model.Car;
import br.com.renan.model.DbCarDao;

@WebServlet("/ControlCar")
public class ControlCar extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DbCarDao carDao;
	private static final String LIST_CAR = "/allcars.jsp";
	private static final String ADD_OR_UPDATE = "/car.jsp";

	public ControlCar() {
		carDao = new DbCarDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String forward = "";

		if (request.getParameter("action") == null) {
			forward = LIST_CAR;
			request.setAttribute("cars", carDao.getAll());
		} else {

			if (action.equals("add")) {
				forward = ADD_OR_UPDATE;

			} else if (action.equals("update")) {
				forward = ADD_OR_UPDATE;
				int id = Integer.parseInt(request.getParameter("carId"));
				Car car;
				car = carDao.getById(id);
				request.setAttribute("car", car);

			} else if (action.equals("delete")) {
				forward = LIST_CAR;
				int id = Integer.parseInt(request.getParameter("carId"));
				Car car;
				car = carDao.getById(id);
				carDao.delete(car);
				request.setAttribute("cars", carDao.getAll());
			}
		}

		request.getRequestDispatcher(forward).forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String carId = request.getParameter("carId");
		Car car = new Car();
		car.setBrand(request.getParameter("brand"));
		car.setModel(request.getParameter("model"));
		car.setWebsite(request.getParameter("website"));
		if (carId.isEmpty()) {
			carDao.add(car);
		} else {
			car.setId(Integer.parseInt(request.getParameter("carId")));
			carDao.update(car);
		}
		request.setAttribute("cars", carDao.getAll());
		request.getRequestDispatcher(LIST_CAR).forward(request, response);
	}

}
