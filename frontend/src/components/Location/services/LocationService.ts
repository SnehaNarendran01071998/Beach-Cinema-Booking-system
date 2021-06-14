import axios from "axios";
import baseURL from "../../../api/base";
import { LocationResponse } from "../model/LocationResponse";

export default async function getAllLocations() {
  const response = await axios.get<LocationResponse[]>(`${baseURL}/location/all`);
  return response.data;
}
