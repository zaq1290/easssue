import { FC, useState, useEffect } from 'react';
import ReactCalendarHeatmap from 'react-calendar-heatmap';
import 'react-calendar-heatmap/dist/styles.css';

const HeatMapCalendar = () => {
  return (
    <>
      <div className="heatmap h-[100%] mr-[289px] flex items-center">
        <div className="calendar-text text-[1.4rem] w-[430px] font-service mr-10">
          <div>{`사용자의 이용 내역 확인을 위한 캘린더 히트맵`}</div>
        </div>
        <div  className=" bg-slate-300  border-[1px] border-black flex justify-center h-[15rem] w-[15rem]">
          <div className="h-full flex p-5 mx-5">
            <ReactCalendarHeatmap
              startDate={new Date('2022-10-31')}
              endDate={new Date('2022-12-01')}
              showWeekdayLabels={false}
              showMonthLabels={false}
              classForValue={(value) => {
                if (!value) {
                  return 'color-empty';
                } else if (value.count >= 10) {
                  return `color-gitlab-4`;
                } else if (value.count >= 6) {
                  return `color-gitlab-3`;
                } else if (value.count >= 2) {
                  return `color-gitlab-2`;
                } else if (value.count == 1) {
                  return `color-gitlab-1`;
                }
              }}
              values={[
                { date: '2022-11-01', count: 1 },
                { date: '2022-11-02', count: 3 },
                { date: '2022-11-03', count: 6 },
                { date: '2022-11-04', count: 3 },
                { date: '2022-11-05', count: 7 },
                { date: '2022-11-06', count: 6 },
                { date: '2022-11-07', count: 12 },
                { date: '2022-11-09', count: 1 },
                { date: '2022-11-10', count: 1 },
                { date: '2022-11-11', count: 8 },
                { date: '2022-11-14', count: 6 },
                { date: '2022-11-15', count: 12 },
                { date: '2022-11-16', count: 1 },
                { date: '2022-11-17', count: 3 },
                { date: '2022-11-18', count: 3 },
                { date: '2022-11-19', count: 5 },
                { date: '2022-11-20', count: 1 },
                { date: '2022-11-22', count: 122 },
                { date: '2022-11-23', count: 7 },
                { date: '2022-11-24', count: 1 },
                { date: '2022-11-25', count: 3 },
                { date: '2022-11-26', count: 6 },
                { date: '2022-11-28', count: 6 },
                { date: '2022-11-29', count: 1 },
                { date: '2022-11-30', count: 10 },
                { date: '2022-12-01', count: 1 }
              ]}
            />
          </div>
        </div>
      </div>
    </>
  );
};

export default HeatMapCalendar;
