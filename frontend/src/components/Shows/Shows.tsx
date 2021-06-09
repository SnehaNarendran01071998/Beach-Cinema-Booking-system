import React, { useEffect } from "react";
import "./styles/Shows.scss";
import { Grid, IconButton, Paper } from "@material-ui/core";
import FormControl from "@material-ui/core/FormControl";
import Select from "@material-ui/core/Select";
import InputLabel from "@material-ui/core/InputLabel";
import MenuItem from "@material-ui/core/MenuItem";

import getAllLocations from "../Location/services/LocationService";
import getShowsForLocation from "./services/ShowService";
import { LocationResponse } from "../Location/model/LocationResponse";
import { ShowDetailsResponse } from "./models/ShowDetailsResponse";
import { ShowDetails } from "./models/ShowDetails";
import { Storage } from "aws-amplify";
import { useHistory } from "react-router-dom";

const Shows: React.FC = (props) => {
  const [showDetails, setShowDetails] = React.useState<ShowDetails[]>([]);
  const [locations, setLocations] = React.useState<LocationResponse[]>([]);
  const [selectedLocation, setSelectedLocation] =
    React.useState<LocationResponse>();
  const [isLoading, setLoading] = React.useState(true);

  const getImageFromAWS = async (showId: number) => {
    let imageUrl: string | Object = "";
    try {
      imageUrl = await Storage.get(`${showId}.jpeg`).then((image) => image);
    } finally {
      return imageUrl as string;
    }
  };

  // const handleClick = () => {
  //   const history = useHistory();
  //   history.push("/film");
  // };

  const handleChange = async (event: any) => {
    setSelectedLocation(event.target.value as LocationResponse);
    await getShowsForLocation(event.target.value.id).then(async (response) => {
      if (response.length !== 0) {
        const result = await constructShowDetails(response).then((images) => {
          return images;
        });
        setShowDetails(result);
      } else {
        setShowDetails([]);
      }
    });
  };

  const constructShowDetails = async (
    showDetailsResponse: ShowDetailsResponse[]
  ): Promise<ShowDetails[]> => {
    var showsWithImages: ShowDetails[] = [];

    await new Promise<void>((resolve) => {
      showDetailsResponse?.forEach(async (show) => {
        try {
          var obj: ShowDetails = {
            film: show.film,
            id: show.id,
            imageUrl:
              (await getImageFromAWS(show.id).then((image) => image)) ?? "",
          };
        } catch (error) {
          console.error(error);
        } finally {
          showsWithImages.push(obj);
          if (showsWithImages.length === showDetailsResponse.length) {
            resolve();
          }
        }
      });
    });

    return showsWithImages;
  };

  useEffect(() => {
    const locationsResponse = getAllLocations();
    locationsResponse.then((response) => {
      setLocations(response);
      setLoading(false);
    });
  }, []);

  return (
    <div>
      <div className="location">
        <FormControl>
          <InputLabel htmlFor="location-select">Select Location</InputLabel>
          <Select
            id="location-select"
            onChange={handleChange}
            className="select-location"
            value={selectedLocation ?? ""}
            data-testid="select"
          >
            {locations.map((location) => (
              <MenuItem
                data-testid="menu"
                key={location.id}
                //Added ts-ignore to set an object as value
                // @ts-ignore [2]
                value={location}
              >
                {location.name}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </div>
      <div className="movies">
        {
          <Grid container spacing={2}>
            {selectedLocation && showDetails.length === 0 ? (
              <div>No Shows for this location</div>
            ) : (
              showDetails.map((show) => {
                return (
                  <Grid key={show.id} item xs={2}>
                    <IconButton>
                      <Paper data-testid="movie-paper">
                        <div>
                          <img src={show.imageUrl} className="film-image" />
                          <br />
                          {show.film}
                          <br />
                        </div>
                      </Paper>
                    </IconButton>
                  </Grid>
                );
              })
            )}
          </Grid>
        }
      </div>
    </div>
  );
};

export default Shows;
