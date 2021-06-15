import axios from "axios";
import baseURL from "../../../api/base";
import { LocationResponse } from "../model/LocationResponse";

export default async function getAllLocations() {
  const herokuapp = "https://cinema-booking-backend.herokuapp.com";
  const localhost = "http://localhost:9090";
  const proxy = "https://corsanywhere.herokuapp.com/";

  const url =
    process.env.NODE_ENV === "production" ? `${proxy}${baseURL}` : baseURL;
  const headerUrl =
    process.env.NODE_ENV === "production" ? `${herokuapp}` : localhost;
  const response = await axios.get<LocationResponse[]>(`${url}/location/all`, {
    headers: { Origin: headerUrl },
  });
  return response.data;
}
