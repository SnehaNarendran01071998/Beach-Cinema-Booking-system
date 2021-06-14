import axios from "axios";
import baseURL from "../../../api/base";
import { LocationResponse } from "../model/LocationResponse";
import getAllLocations from "./LocationService";
describe("Location Service", () => {
  it("should get list of all locations", async () => {
    const url = `/location/all`;
    const respose: LocationResponse[] = [
      {
        id: 1,
        name: "the first location",
      },
      {
        id: 2,
        name: "the second location",
      },
    ];

    (axios.get as jest.Mock).mockResolvedValueOnce({ data: respose });
    var actual = await getAllLocations();
    expect(axios.get).toHaveBeenCalledWith(url);
    expect(actual).toBe(respose);
  });
});
