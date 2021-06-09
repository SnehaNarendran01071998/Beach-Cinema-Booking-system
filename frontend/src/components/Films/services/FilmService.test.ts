import axios from "axios";
import baseURL from "../../../api/base";
import { FilmResponse } from "../model/FilmResponse";
import getFilmsById from "./FilmService";
describe("Film Service", () => {
  it("should get list of film given film id", async () => {
    let filmId = 1;
    const url = `${baseURL}/films/film?filmId=${filmId}`;
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

    (axios.get as jest.Mock).mockResolvedValueOnce({ data: respose });
    var actual = await getFilmsById(filmId);
    expect(axios.get).toHaveBeenCalledWith(url);
    expect(actual).toBe(respose);
  });
});
