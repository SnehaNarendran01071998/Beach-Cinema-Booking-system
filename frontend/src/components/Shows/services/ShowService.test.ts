import axios from "axios";
import baseURL from "../../../api/base";
import { ShowDetailsResponse } from "../models/ShowDetailsResponse";
import getShowsForLocation from "./ShowService";

describe("Show Service", () => {
  it("should get list of show details given location id", async () => {
    let locationId = 1;
    const url = `${baseURL}/showDetails/location?locationId=${locationId}`;
    const respose: ShowDetailsResponse[] = [
      {
        id: locationId,
        film: "some film name",
      },
    ];

    (axios.get as jest.Mock).mockResolvedValueOnce({ data: respose });
    var actual = await getShowsForLocation(locationId);
    expect(axios.get).toHaveBeenCalledWith(url);
    expect(actual).toBe(respose);
  });
});
