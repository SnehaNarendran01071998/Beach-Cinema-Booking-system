import React, { useEffect } from "react";
import "./styles/Films.scss";
import { FilmResponse } from "./model/FilmResponse";
import getFilmsById from "./services/FilmService";
import Loader from "react-loader-spinner";
import { AxiosError } from "axios";

const Films = (props: { filmId: number; imageUrl: string }) => {
  const [isLoading, setLoading] = React.useState(true);
  const [isError, setError] = React.useState(false);
  const [films, setFilms] = React.useState<FilmResponse[]>([]);

  useEffect(() => {
    const filmResponse = getFilmsById(props.filmId);
    filmResponse
      .then((response) => {
        setFilms(response);
        setLoading(false);
      })
      .catch((error: AxiosError) => {
        setError(true);
      });
  }, []);

  return (
    <div>
      {isError && (<div>Oops! Something went wrong. Please try again later</div>)}
      {isLoading && (
        <Loader
          type="Puff"
          color="#00BFFF"
          height={100}
          width={100} //3 secs
        />
      )}
      {films.length === 0 ? (
        <div>No data to display</div>
      ) : (
        <div className="about">
          <div className="film-image">
            <img src={props.imageUrl} className="film-image" />
          </div>
          <div className="film-name">{films[0].film}</div>
          <div className="duration">{films[0].duration}</div>
          <div className="description">{films[0].description}</div>
        </div>
      )}
    </div>
  );
};

export default Films;
