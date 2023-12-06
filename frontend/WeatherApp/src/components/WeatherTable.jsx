import { useState, useEffect } from 'react';

function WeatherTable() {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch('https://api.open-meteo.com/v1/forecast?latitude=52.155&longitude=5.3875&current=temperature_2m,relative_humidity_2m,apparent_temperature,rain,showers,snowfall,cloud_cover,wind_speed_10m,wind_direction_10m')
      .then(response => response.json())
      .then(jsonData => {
          setData([jsonData.current]);
          console.table([jsonData.current]);
      })
      .catch(error => console.error('Error fetching weather data:', error));
  }, []);

  return (
    <div className="App">
      <table className='styled-table'>
        <thead>
          <tr>
            <th>Time</th>
            <th>Temperature (°C)</th>
            <th>Apparent Temperature (°C)</th>
            <th>Relative Humidity (%)</th>
            <th>Rain</th>
            <th>Showers</th>
            <th>Snowfall</th>
            <th>Cloud Cover (%)</th>
            <th>Wind Speed (m/s)</th>
            <th>Wind Direction (°)</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item, index) => (
            <tr className='active-row' key={index}>
              <td>{item.time}</td>
              <td>{item.temperature_2m}</td>
              <td>{item.apparent_temperature}</td>
              <td>{item.relative_humidity_2m}</td>
              <td>{item.rain}</td>
              <td>{item.showers}</td>
              <td>{item.snowfall}</td>
              <td>{item.cloud_cover}</td>
              <td>{item.wind_speed_10m}</td>
              <td>{item.wind_direction_10m}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default WeatherTable;
