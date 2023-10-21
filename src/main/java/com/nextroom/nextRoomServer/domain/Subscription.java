package com.nextroom.nextRoomServer.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.nextroom.nextRoomServer.enums.SubscriptionPlan;
import com.nextroom.nextRoomServer.enums.SubscriptionStatus;
import com.nextroom.nextRoomServer.util.Timestamped;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    private String googleId;
    private SubscriptionStatus status;
    private SubscriptionPlan plan;
    private LocalDateTime subscribedAt;
    private LocalDate expiryDate;
}
