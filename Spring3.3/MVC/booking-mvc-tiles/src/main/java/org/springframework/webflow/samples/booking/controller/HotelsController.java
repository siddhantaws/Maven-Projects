package org.springframework.webflow.samples.booking.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.webflow.samples.booking.domain.Booking;
import org.springframework.webflow.samples.booking.domain.Hotel;
import org.springframework.webflow.samples.booking.domain.SearchCriteria;
import org.springframework.webflow.samples.booking.services.BookingService;

@Controller
public class HotelsController {

	private BookingService bookingService;

	// Autowire the BookingService object, "JpaBookingService" object.
	@Autowired
	public HotelsController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	// The currentUser is "null" when a user accesses the /hotels/search URL
	// without being in logged in state.
	//
	// Because the return type is "void", the logical view name is set to
	// "/hotels/search", which results in displaying "/hotels/search.jsp".
	@RequestMapping(value = "/hotels/search", method = RequestMethod.GET)
	public void search(SearchCriteria searchCriteria, Principal currentUser,
			Model model) {

		// Display list of bookings of this user if the user is in logged in
		// state.
		if (currentUser != null) {
			List<Booking> bookings = bookingService.findBookings(currentUser
					.getName());
			model.addAttribute("bookingList", bookings);
		}
	}

	// This method gets called when a user submits a hotel search within
	// "/hotels/search.jsp".
	//
	// The list of hotels are then displayed through "hotels/list" logical view,
	// which results in displaying "/hotels/list.jsp"
	@RequestMapping(value = "/hotels-search", method = RequestMethod.GET)
	public String list(SearchCriteria criteria, Model model) {

		// Using the "SearchCriteria", perform the search through
		// "bookingService".
		List<Hotel> hotels = bookingService.findHotels(criteria);

		// The name of the attribute is auto-generated as "hotelList"
		// through "Convention over configuration" principle. It uses
		// the type of "hotels" object. So the result is the same as
		// calling "model.addAttribute("hotelList", hotels);"
		model.addAttribute(hotels);

		// Return logical view name "hotels/list", which results in displaying
		// "hotels/list.jsp".
		return "hotels/list";
	}

	@RequestMapping(value = "/hotels", method = RequestMethod.GET)
	public String listAll(Model model) {
		List<Hotel> hotels = bookingService.findAllHotels();
		// The name of the attribute is auto-generated as "hotelList".
		// Same as model.addAttribute("hotelList", hotels);
		model.addAttribute(hotels);
		return "hotels/list";
	}

	// This method gets called when a user selects a hotel to display
	// the hotel detail information.
	@RequestMapping(value = "/hotels/{id}", method = RequestMethod.GET)
	public String show(@PathVariable Long id, Model model) {
		// The name of the attribute is auto-generated as "hotel"
		// because the return type of "bookingService.findHotelById(id)"
		// is "Hotel".
		model.addAttribute(bookingService.findHotelById(id));
		return "hotels/show";
	}

	// This methods gets called when a user wants to cancel a booking.
	@RequestMapping(value = "/bookings/{id}", method = RequestMethod.DELETE)
	public String deleteBooking(@PathVariable Long id) {
		bookingService.cancelBooking(id);
		return "redirect:../hotels/search";
	}

}
