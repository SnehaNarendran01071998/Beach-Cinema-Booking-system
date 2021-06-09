import React from "react";
import axios from "axios";

import "@testing-library/jest-dom/extend-expect";

import {
  act,
  cleanup,
  fireEvent,
  render,
  screen,
  waitFor,
} from "@testing-library/react";
import { LocationResponse } from "../Location/model/LocationResponse";
import Shows from "./Shows";
import { ShowDetailsResponse } from "./models/ShowDetailsResponse";

describe("Shows", () => {
  afterEach(cleanup);
  it("should render the list and details of shows given location is selected", async () => {
    const respose: LocationResponse[] = [
      {
        id: 1,
        name: "the first location",
      },
      {
        id: 2,
        name: "the second location",
      },
      {
        id: 3,
        name: "the third location",
      },
    ];

    const showDetailsResponse: ShowDetailsResponse[] = [
      {
        id: 1,
        film: "some film name",
      },
      {
        id: 2,
        film: "some other film name",
      },
      {
        id: 3,
        film: "another film name",
      },
    ];

    act(() => {
      (axios.get as jest.Mock).mockResolvedValueOnce({ data: respose });
      (axios.get as jest.Mock).mockResolvedValueOnce({
        data: showDetailsResponse,
      });
    });

    render(<Shows />);
    const selector = document.querySelector("#location-select");
    fireEvent.mouseDown(selector);

    await waitFor(() => {
      screen.getAllByTestId("menu");
    });
    const choice = screen.getByText(/the first location/i);
    fireEvent.click(choice);

    await waitFor(() => {
      const moviePaper = screen.getAllByTestId("movie-paper");
      expect(screen.getByText(/some film name/i)).toBeTruthy();
      expect(screen.getByText(/some other film name/i)).toBeTruthy();
      expect(screen.getByText(/another film name/i)).toBeTruthy();
    });
  });

  it("should render No Shows for this location when movie details are is empty", async () => {
    const respose: LocationResponse[] = [
      {
        id: 1,
        name: "the first location",
      },
      {
        id: 2,
        name: "the second location",
      },
      {
        id: 3,
        name: "the third location",
      },
    ];

    act(() => {
      (axios.get as jest.Mock).mockResolvedValueOnce({ data: respose });
      (axios.get as jest.Mock).mockResolvedValueOnce({
        data: [],
      });
    });

    render(<Shows />);
    const selector = document.querySelector("#location-select");
    fireEvent.mouseDown(selector);

    await waitFor(() => {
      screen.getAllByTestId("menu");
    });
    const choice = screen.getByText(/the first location/i);
    fireEvent.click(choice);

    await waitFor(() => {
      expect(screen.getByText(/No Shows for this location/i));
    });
  });
});
