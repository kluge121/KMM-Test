//
//  Kmm_injector.swift
//  watchosApp Watch App
//
//  Created by 배민수 on 2023/03/06.
//


import SwiftUI
import shared

func startKoin() {
    _koin = KMM_injectorKt.doInitKoin().koin
}

private var _koin: Koin_coreKoin?

var koin: Koin_coreKoin {
    return _koin!
}

extension Koin_coreKoin {
    func get() -> GetTodayT1HUseCase {
        return koin.getDependency(objCClass: GetTodayT1HUseCase.self) as! GetTodayT1HUseCase
    }
}
