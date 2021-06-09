/**
 * @jest-environment jsdom
 */
import React from "react";
import axios from "axios";

import "@testing-library/jest-dom/extend-expect";

import { act, cleanup, render, screen} from "@testing-library/react";
import Films from "./Films";
import { FilmResponse } from "./model/FilmResponse";

describe("Films", () => {
  afterEach(cleanup);
  it("should render the list and details of film given its id", async () => {
    const filmId = 1;
    const imageUrl = "this is film url";
    const respose: FilmResponse[] = [
      {
        id: filmId,
        film: "some film name",
        duration: 100,
        description: "some Description",
        theatre: "this theatre",
        startTime: "02-06-2021T12:00:00",
      },
    ];
    act(() => {
      (axios.get as jest.Mock).mockResolvedValueOnce({ data: respose });
    });
    render(<Films filmId={filmId} imageUrl={imageUrl} />);

    await screen.findByText("some film name");
    await screen.findByText(100);
    await screen.findByText("some Description");
  });

  it("should render No data to display when no details have been fetched", async () => {
    const filmId = 1;
    const imageUrl = "this is film url";

    act(() => {
      (axios.get as jest.Mock).mockResolvedValueOnce({ data: [] });
    });
    render(<Films filmId={filmId} imageUrl={imageUrl} />);

    await screen.findByText("No data to display");
  });

  it("should render error message when there is an internal error", async () => {
    const filmId = 1;
    const imageUrl = "this is film url";

    act(() => {
      (axios.get as jest.Mock).mockImplementation(() =>
        Promise.reject("error")
      );
    });
    render(<Films filmId={filmId} imageUrl={imageUrl} />);

    await screen.findByText(
      "Oops! Something went wrong. Please try again later"
    );
  });
});
