import axios from "axios";
import baseURL from "../../../api/base";
import { FilmResponse } from "../model/FilmResponse";

export default async function getFilmsById(filmId: number) {
  const response = await axios.get<FilmResponse[]>(
    `${baseURL}/films/film?filmId=` + filmId
  );
  return response.data;
}
