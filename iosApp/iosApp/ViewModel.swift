//
//  ViewModel.swift
//  watchosApp Watch App
//
//  Created by 배민수 on 2023/03/06.
//


import Foundation
import shared

class ViewModel: ObservableObject {
    
    @Published var text = " "
    
    init() {
        
        let getTodayWeather: GetTodayT1HUseCase = koin.get()
        
        var request  = TodayWeatherRequest(
            serviceKey: "VxgVYE9o8YvluZ1BVJkMQBdgYbnj35BxfB757jx5T2ykSSNrwq4L3amRae3UKgF8sg4eyaQdmcRzsBdO2n2jqA==",
            pageNo: 1,
            numOfRows: 1000,
            dataType: "JSON",
            baseDate: "20230306",
            baseTime: "0600",
            nx: "57",
            ny: "127")
        
        getTodayWeather.invoke(request : request) {data , error in
            DispatchQueue.main.async {
                if let data = data {
                    self.text = "\(data.first?.date)#\(data.first?.time) :  \(data.first?.obsrValue)도"
                } else {
                    self.text = error?.localizedDescription ?? "error1"
                }
            }
            
        }
        
    }
    
}

