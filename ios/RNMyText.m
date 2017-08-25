//
//  RNMyText.m
//  RNArkitDemo
//
//  Created by Sean Tempesta on 8/25/17.
//  Copyright © 2017 Facebook. All rights reserved.
//
#import "RNMyText.h"
#import <React/UIView+React.h>

@implementation RNMyText

RCT_EXPORT_MODULE();

- (UIView *)view
{
  return [UILabel new];
}

RCT_EXPORT_VIEW_PROPERTY(text, NSString *);

@end
