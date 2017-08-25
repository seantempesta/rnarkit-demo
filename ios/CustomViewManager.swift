//
//  CustomViewManager.swift
//  RNArkitDemo
//
//  Created by Sean Tempesta on 8/25/17.
//  Copyright © 2017 Facebook. All rights reserved.
//

import Foundation
@objc(CustomViewManager)
class CustomViewManager : RCTViewManager {
  override func view() -> UIView! {
    return CustomView();
  }
}
