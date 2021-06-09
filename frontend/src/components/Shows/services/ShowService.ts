import axios from "axios";
import baseURL from "../../../api/base";
import { ShowDetailsResponse } from "../models/ShowDetailsResponse";

export default async function getShowsForLocation(location: number) {
  const response = await axios.get<ShowDetailsResponse[]>(`${baseURL}/showDetails/location?locationId=`+location);
  return response.data;
}
